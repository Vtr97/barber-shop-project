package br.com.marques.barbershopapi.service;

import br.com.marques.barbershopapi.entity.ScheduleEntity;

public interface IScheduleService {

    ScheduleEntity save(final ScheduleEntity entity);

    void delete(final long id);
}
