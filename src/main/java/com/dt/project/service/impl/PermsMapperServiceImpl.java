package com.dt.project.service.impl;

import com.dt.project.mapper.PermsMapper;
import com.dt.project.service.PermsMapperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermsMapperServiceImpl implements PermsMapperService {

    @Autowired
    private PermsMapper permsMapper;

    @Override
    public Set<String> findByPerms(Long uid) {
        //获得用户的权限
        List<String> perms = permsMapper.findByPerms(uid);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
