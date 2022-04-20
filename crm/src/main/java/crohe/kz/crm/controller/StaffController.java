package crohe.kz.crm.controller;

import crohe.kz.crm.dto.StaffDto;
import crohe.kz.crm.entity.Staff;
import crohe.kz.crm.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/list")
    public List<StaffDto> getAllStaff(){
        return staffService.getAllStaff();
    }

    @GetMapping("/get/{id}")
    public StaffDto getStaffById(@PathVariable("id") Long id){
        return staffService.getStaffById(id);
    }

    @PostMapping("/new")
    public Staff saveNewStaff(@RequestBody Staff staff){
        return staffService.saveNewStaff(staff);
    }

    @PutMapping("/update/{id}")
    public Staff updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff){
        return staffService.updateStaff(id, staff);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStaff(@PathVariable Long id){
        staffService.deleteStaff(id);
    }
}
