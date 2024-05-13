package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;



import com.ouacrimecoders.backoffice.autopartsmanager.criteria.PackageCriteria;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;

import java.util.List;

public interface PackageService {
    public List<PackageDto> findPackagesByCriteria(PackageCriteria packageCriteria) ;
    public PackageDto findPackagesById(Long id) throws EntityNotFoundException;
    public PackageDto persistPackages(PackageDto packagesDto) throws EntityNotFoundException ;
    public PackageDto updatePackages(Long id, PackageDto packagesDto) throws EntityNotFoundException ;
    public ResponseDto deletePackagesById(Long id) throws EntityNotFoundException ;
    }
