package br.com.marques.barbershopapi.service.impl;

import br.com.marques.barbershopapi.entity.ScheduleEntity;
import br.com.marques.barbershopapi.repository.IScheduledRepository;
import br.com.marques.barbershopapi.service.IScheduleService;
import br.com.marques.barbershopapi.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduledRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
