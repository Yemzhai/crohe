package crohe.kz.crm.service;

import crohe.kz.crm.dto.StaffDto;
import crohe.kz.crm.entity.Staff;

import java.util.List;

public interface StaffService {
    List<StaffDto> getAllStaff();
    StaffDto getStaffById(Long id);
    Staff saveNewStaff(Staff staff);
    Staff updateStaff(Long id, Staff staff);
    void deleteStaff(Long id);
}
