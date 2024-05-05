package com.ouacrimecoders.backoffice.autopartsmanager.services.inter;



import com.ouacrimecoders.backoffice.autopartsmanager.criteria.PackageProductCriteria;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.PackageProductDto;
import com.ouacrimecoders.backoffice.autopartsmanager.dtos.ResponseDto;
import com.ouacrimecoders.backoffice.autopartsmanager.exceptions.EntityNotFoundException;

import java.util.List;

public interface PackageProductService {
    public ResponseDto deleteProductFromPackage(Long packageId) throws EntityNotFoundException;
    public ResponseDto deletePackageProductById(Long id) throws EntityNotFoundException;
    public PackageProductDto updatePackageProduct(Long id, PackageProductDto PackageProductDto) throws EntityNotFoundException;
    public PackageProductDto persistPackageProduct(PackageProductDto PackageProductDto) throws EntityNotFoundException ;
    public PackageProductDto findPackageProductById(Long id) throws EntityNotFoundException ;
    public List<PackageProductDto> findPackageProductByCriteria(PackageProductCriteria PackageProductCriteria) throws EntityNotFoundException ;

    }
