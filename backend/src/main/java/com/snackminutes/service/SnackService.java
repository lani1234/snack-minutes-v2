package com.snackminutes.service;

import com.snackminutes.exception.ResourceNotFoundException;
import com.snackminutes.model.Snack;
import com.snackminutes.repository.SnackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnackService {

    private final SnackRepository snackRepository;

    public SnackService(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    public List<Snack> getAllSnacks() {
        return snackRepository.findAll();
    }

    public Snack getSnackById(Long id) {
        return snackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snack not found with id: " + id));
    }

    public Snack createSnack(Snack snackModel) {
        return snackRepository.save(snackModel);
    }

    public List<Snack> createSnacks(List<Snack> snackModels) {
        return snackRepository.saveAll(snackModels); // Save all snacks in one go
    }

    public Snack updateSnack(Long id, Snack snackModel) {
        // Check if the snack exists
        if (!snackRepository.existsById(id)) {
            throw new ResourceNotFoundException("Snack not found with id " + id);
        }
        Snack existingSnack = getSnackById(id);
        existingSnack.setName(snackModel.getName());
        existingSnack.setServingSize(snackModel.getServingSize());
        existingSnack.setCaloriesPerServing(snackModel.getCaloriesPerServing());
        return snackRepository.save(snackModel);
    }

    public void deleteSnack(Long id) {
        if (!snackRepository.existsById(id)) {
            throw new ResourceNotFoundException("Snack not found with id " + id);
        }
        snackRepository.deleteById(id);
    }
}
