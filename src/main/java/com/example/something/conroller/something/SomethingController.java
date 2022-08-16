package com.example.something.conroller.something;

import com.example.something.conroller.something.dto.SomethingCreateUpdateDto;
import com.example.something.conroller.something.dto.SomethingDto;
import com.example.something.service.SomethingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.something.conroller.Endpoints.*;

@RestController
@RequestMapping(BASE)
@RequiredArgsConstructor
@Slf4j
public class SomethingController {

    private final ModelMapper modelMapper;
    private final SomethingService somethingService;

    @PostMapping(SOMETHING)
    @ResponseStatus(HttpStatus.CREATED)
    public SomethingDto createSomething(@RequestBody SomethingCreateUpdateDto createDto) {
        return modelMapper.map(somethingService.create(createDto), SomethingDto.class);
    }

    @PutMapping(SOMETHING + _ID)
    @ResponseStatus(HttpStatus.OK)
    public SomethingDto updateSomething(@PathVariable(value = "id") String id,
                                        @RequestBody SomethingCreateUpdateDto updateDto) {
        return modelMapper.map(somethingService.update(id, updateDto), SomethingDto.class);

    }
}