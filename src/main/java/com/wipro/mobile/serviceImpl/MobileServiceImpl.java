package com.wipro.mobile.serviceImpl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.wipro.mobile.dto.MobileDTO;
import com.wipro.mobile.entity.Category;
import com.wipro.mobile.entity.Mobile;
import com.wipro.mobile.exception.ResourceNotFoundException;
import com.wipro.mobile.repository.MobileRepo;
import com.wipro.mobile.service.MobileService;

import java.util.List;

public class MobileServiceImpl  implements MobileService{

	 @Override
	    public MobileDTO saveMobile(MobileDTO mobileDTO) {
	        Mobile mobileEntity = modelMapper.map(mobileDTO, Mobile.class);

	        Mobile newMobile = MobileRepo.save(mobileEntity);


	        return modelMapper.map(newMobile, MobileDTO.class);

	    }
	 @Override
	    public Set<MobileDTO> findAllMobiles() {
	        List<Mobile> mobiles = MobileRepo.findAll();
	        return mobiles.stream().map(mobile -> modelMapper.map(mobile, MobileDTO.class)).collect(Collectors.toSet());
	    }

	    @Override
	    public MobileDTO findMobileById(long mobileId) throws ResourceNotFoundException{
	        Optional<Mobile> optionalMobile = MobileRepo.findById(mobileId);
	        if(optionalMobile.isEmpty()) {
	            throw new ResourceNotFoundException("Mobile not found with id: "+mobileId);
	        }

	        Mobile mobile = optionalMobile.get();

	        return modelMapper.map(mobile, MobileDTO.class);

	    }
	    @Override
	    public void deleteMobile(long mobileId) {
	        Optional<Mobile> optionalMobile = MobileRepo.findById(mobileId);
	        if(optionalMobile.isEmpty()) {
	            throw new ResourceNotFoundException("Mobile not found with id: "+mobileId);
	        }

	        Mobile mobile = optionalMobile.get();

	        mobileRepository.delete(mobile);

	    }
	    
	    @Override
	    public MobileDTO updateMobile(MobileDTO mobileDTO) {
	        Optional<Mobile> optionalMobile = MobileRepo.findById(mobileDTO.getId());
	        if(optionalMobile.isEmpty()) {
	            throw new ResourceNotFoundException("Mobile not found with id: "+mobileDTO.getId());
	        }

	        Mobile mobileEntity = modelMapper.map(mobileDTO, Mobile.class);

	        MobileRepo.save(mobileEntity);

	        return modelMapper.map(mobileEntity, MobileDTO.class);

	    }

	    @Override
	    public Set<MobileDTO> findAllMobilesByCategory(long categoryId) {
	        Optional<Category> optionalCategory = repo.findById(categoryId);
	        if(optionalCategory.isEmpty()) {
	            throw new ResourceNotFoundException("Category not found with id: "+categoryId);
	        }

	        Category category = optionalCategory.get();
	        List<Mobile> mobiles = category.getMobilelist();

	        Set<MobileDTO> mobileDTOs = mobiles.stream().map(mobile -> modelMapper.map(mobile, MobileDTO.class))
	                .collect(Collectors.toSet());

	        return mobileDTOs;
	    }

}
