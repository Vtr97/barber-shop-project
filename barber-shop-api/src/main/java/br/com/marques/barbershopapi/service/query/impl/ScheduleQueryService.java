package br.com.marques.barbershopapi.service.query.impl;

import br.com.marques.barbershopapi.entity.ScheduleEntity;
import br.com.marques.barbershopapi.exception.NotFoundException;
import br.com.marques.barbershopapi.exception.ScheduleInUseException;
import br.com.marques.barbershopapi.repository.IScheduledRepository;
import br.com.marques.barbershopapi.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;


@Repository
@AllArgsConstructor
public class ScheduleQueryService implements IScheduleQueryService {
    private final IScheduledRepository repository;

    @Override
    public ScheduleEntity findById(long id) {
        return repository.findById(id).orElseThrow(() ->
                new NotFoundException("Agendamento não encontrado")
        );
    }

    @Override
    public List<ScheduleEntity> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)) {
            var message = "Já existe um cliente agendado no horário solicitado";
            throw new ScheduleInUseException(message);
        }
    }
}
