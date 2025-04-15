package com.ximps.limit_service.mapper;

import com.ximps.common.mapper.AbstractMapper;
import com.ximps.limit_service.dto.PaymentDto;
import com.ximps.limit_service.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends AbstractMapper<Payment, PaymentDto> {}
