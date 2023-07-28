package com.mtm.plan.bl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtm.plan.bl.dto.RoleDTO;
import com.mtm.plan.bl.service.RoleService;
import com.mtm.plan.persistence.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public List<RoleDTO> doGetAllRole() {
        return this.roleRepo.findAll().stream().map(r -> new RoleDTO(r)).toList();
    }

}
