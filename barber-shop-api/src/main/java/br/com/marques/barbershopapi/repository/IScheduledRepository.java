package br.com.marques.barbershopapi.repository;

import br.com.marques.barbershopapi.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface IScheduledRepository extends JpaRepository<ScheduleEntity, Long> {
    List<ScheduleEntity> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc
            (final OffsetDateTime startAt, final OffsetDateTime endAt);

    boolean existsByStartAtAndEndAt
            (final OffsetDateTime startAt, final OffsetDateTime endAt);
}

