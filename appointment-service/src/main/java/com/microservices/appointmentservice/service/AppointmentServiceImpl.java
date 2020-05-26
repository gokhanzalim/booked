package com.microservices.appointmentservice.service;

import com.microservices.appointmentservice.dto.AppointmentDto;
import com.microservices.appointmentservice.entity.Appointment;
import com.microservices.appointmentservice.repository.AppointmentRepository;
import com.microservices.CustomerServiceClient;
import com.microservices.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final CustomerServiceClient customerServiceClient;

    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {

        String nameSurname = "";
        Appointment appointment = modelMapper.map(appointmentDto,Appointment.class);

        ResponseEntity<CustomerDto> customerDto =
                                 customerServiceClient.get(appointmentDto.getCustomerId());

        if (customerDto != null){
            nameSurname = customerDto.getBody().getName() + " " + customerDto.getBody().getSurname();
            appointmentDto.setCustomerId(customerDto.getBody().getId());
            appointmentDto.setCustomerName(nameSurname);
        }


        appointmentRepository.save(appointment);
        appointmentDto.setId(appointment.getId());
        return appointmentDto;
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
