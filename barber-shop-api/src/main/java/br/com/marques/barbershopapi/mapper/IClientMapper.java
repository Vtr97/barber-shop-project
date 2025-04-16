package br.com.marques.barbershopapi.mapper;


import br.com.marques.barbershopapi.controller.ClientController;
import br.com.marques.barbershopapi.controller.request.SaveClientRequest;
import br.com.marques.barbershopapi.controller.request.UpdateClientRequest;
import br.com.marques.barbershopapi.controller.response.ClientDetailResponse;
import br.com.marques.barbershopapi.controller.response.ListClientResponse;
import br.com.marques.barbershopapi.controller.response.SaveClientResponse;
import br.com.marques.barbershopapi.controller.response.UpdateClientResponse;
import br.com.marques.barbershopapi.entity.ClientEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse ToUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);
}
