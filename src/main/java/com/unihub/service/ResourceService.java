package com.unihub.service;

import com.unihub.entity.Resource;
import java.util.List;

public interface ResourceService {

    Resource saveResource(Resource resource);

    List<Resource> getAllResources();

    Resource getResourceById(Long id);

    Resource updateResource(Resource resource);

    void deleteResource(Long id);

}