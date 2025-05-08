package com.snackminutes.controller;

import com.snackminutes.converter.SnackConverter;
import com.snackminutes.dto.SnackDTO;
import com.snackminutes.model.Snack;
import com.snackminutes.service.SnackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snacks")
public class SnackController {

    private final SnackService snackService;
    private final SnackConverter snackConverter;

    public SnackController(SnackService snackService, SnackConverter snackConverter) {
        this.snackService = snackService;
        this.snackConverter = snackConverter;
    }

    @GetMapping("/test")
    public Snack testSnack() {
        return Snack.builder()
                .name("Test Snack")
                .servingSize("1 bar")
                .caloriesPerServing(100)
                .build();
    }

    @GetMapping
    public List<SnackDTO> getAllSnacks() {
        List<Snack> allSnacks = snackService.getAllSnacks();
        return allSnacks.stream()
                .map(snackConverter::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public SnackDTO getSnackById(@PathVariable Long id) {
        Snack snack = snackService.getSnackById(id);
        return snackConverter.convert(snack);
    }

    @PostMapping
    public SnackDTO createSnack(@RequestBody Snack snack) {
        Snack snackModel =  snackService.createSnack(snack);
        return snackConverter.convert(snackModel);
    }

    @PostMapping("/bulk")
    public List<SnackDTO> createSnacks(@RequestBody List<Snack> snacks) {
        List<Snack> snackModelList = snackService.createSnacks(snacks);
        return snackModelList.stream()
                .map(snackConverter::convert)
                .toList();
    }

    @PutMapping("/{id}")
    public SnackDTO updateSnack(@PathVariable Long id, @RequestBody Snack snack) {
        Snack snackModel = snackService.updateSnack(id, snack);
        return snackConverter.convert(snackModel);
    }

    @DeleteMapping("/{id}")
    public void deleteSnack(@PathVariable Long id) {
        snackService.deleteSnack(id);
    }
}
