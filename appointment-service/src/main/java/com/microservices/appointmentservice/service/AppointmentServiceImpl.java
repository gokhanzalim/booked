package com.microservices.appointmentservice.service;

import com.microservices.appointmentservice.dto.AppointmentDto;
import com.microservices.appointmentservice.entity.Appointment;
import com.microservices.appointmentservice.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {

        Appointment appointment = modelMapper.map(appointmentDto,Appointment.class);

        appointmentRepository.save(appointment);

        return modelMapper.map(appointment,AppointmentDto.class);
    }

    @Transactional
    @Override
    public AppointmentDto update(String id, AppointmentDto appointmentDto) {

        /*Optional<Appointment> employee =
                Optional.ofNullable(appointmentRepository.findById(id)
                        .orElseThrow(IllegalArgumentException::new));



        appointmentRepository.save(updatedAppointment);

        return modelMapper.map(updatedAppointment,AppointmentDto.class);*/
        return null;
    }

    @Override
    public Boolean delete(String id) {

        this.getById(id);

        appointmentRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public AppointmentDto getById(String id) {

        Appointment appointment = appointmentRepository.findById(id).get();

        if (appointment == null)
            throw new IllegalArgumentException("appointment cannot  found!");


        return modelMapper.map(appointment,AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> getAll() {

        List<Appointment> appointmentList = appointmentRepository.findAll();

        List<AppointmentDto> appointmentDtoList =
                Arrays.asList(modelMapper.map(appointmentList,AppointmentDto[].class));

        return appointmentDtoList;
    }
}
