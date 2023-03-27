package pl.jewusiak.inwentarzeeapi.controllers;

import org.springframework.web.bind.annotation.*;
import pl.jewusiak.inwentarzeeapi.models.Equipment;
import pl.jewusiak.inwentarzeeapi.services.EquipmentService;

@RestController
@RequestMapping(value = "equipment")
public class EquipmentController {


    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("")
    public Iterable<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @GetMapping("/{id}")
    public Equipment getEquipmentById(@PathVariable long id) {
        return equipmentService.getEquipmentById(id);
    }

    @PostMapping(value = "")
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    @PutMapping("/{id}")
    public Equipment updateEquipment(@RequestBody String json, @PathVariable long id) {
        return equipmentService.updateEquipment(json, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable long id) {
        equipmentService.deleteEquipmentById(id);
    }

}
