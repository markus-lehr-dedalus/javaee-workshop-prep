package com.dedalus.mapper;

import com.dedalus.entity.ManufacturerEntity;
import com.dedalus.model.ManufacturerModel;
import com.dedalus.service.ManufacturerService;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class ManufacturerMapper {
    @Inject
    UUIDMapper uuidMapper;
    @Inject
    TimeMapper timeMapper;

    public ManufacturerEntity mapToEntity(ManufacturerModel manufacturerModel) {
        return new ManufacturerEntity()
                .setId(uuidMapper.mapToUUID(manufacturerModel.getId()))
                .setName(manufacturerModel.getName())
                .setExistsSince(timeMapper.mapToInstant(manufacturerModel.getExistsSince()));
    }

    public ManufacturerModel mapToModel(ManufacturerEntity manufacturerEntity) {
        log.info("mapping entity " + manufacturerEntity);
        return new ManufacturerModel()
                .setId(uuidMapper.mapToString(manufacturerEntity.getId()))
                .setName(manufacturerEntity.getName())
                .setExistsSince(timeMapper.mapToString(manufacturerEntity.getExistsSince()));
    }
}
