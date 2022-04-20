package crohe.kz.crm.service.impl;

import crohe.kz.crm.dto.StaffDto;
import crohe.kz.crm.entity.Staff;
import crohe.kz.crm.exception.NotFoundException;
import crohe.kz.crm.repository.StaffRepository;
import crohe.kz.crm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<StaffDto> getAllStaff() {
        return StaffDto.toModal(staffRepository.findAll());
    }

    @Override
    public StaffDto getStaffById(Long id) {
        return StaffDto.toModal(staffRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public Staff saveNewStaff(Staff staff) {
        return staffRepository.save(staff);    }

    @Override
    public Staff updateStaff(Long id, Staff staff) {
        Staff personUpdate = staffRepository.findById(id).orElseThrow(NotFoundException::new);

        personUpdate.setPosition(staff.getPosition());
        personUpdate.setFirstName(staff.getFirstName());
        personUpdate.setLastName(staff.getLastName());
        personUpdate.setEmail(staff.getEmail());
        personUpdate.setPhoneNumber(staff.getPhoneNumber());
        personUpdate.setLogin(staff.getLogin());
        personUpdate.setPassword(staff.getPassword());

        staffRepository.save(personUpdate);
        return personUpdate;
    }

    @Override
    public void deleteStaff(Long id) {
        Staff personDelete = staffRepository.findById(id).orElseThrow(NotFoundException::new);
        if (personDelete != null){
            staffRepository.deleteById(id);
        }
    }
}
