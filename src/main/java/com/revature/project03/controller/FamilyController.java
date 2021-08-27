package com.revature.project03.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project03.entity.Family;
import com.revature.project03.exception.ResourceNotFoundException;
import com.revature.project03.repository.FamilyRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/family")
public class FamilyController {
	@Autowired
	private FamilyRepository familyRepository;

	@GetMapping("/")
	public List<Family> getAllFamilyMembers() {
		return familyRepository.findAll();
	}

	@GetMapping("/family/{id}")
	public ResponseEntity<Family> getFamilyMemberById(@PathVariable(value = "id") Integer familyMemberId)
			throws ResourceNotFoundException {
		Family familyMember = familyRepository.findById(familyMemberId)
				.orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found for this id :: " + familyMemberId));
		return ResponseEntity.ok().body(familyMember);
	}

	@PostMapping("/family")
	public Family createFamilyMember(@Valid @RequestBody Family familyMember) {
		return familyRepository.save(familyMember);
	}

	@PutMapping("/family/{id}")
	public ResponseEntity<Family> updateFamilyMember(@PathVariable(value = "id") Integer familyMemberId,
			@Valid @RequestBody Family familyMemberDetails) throws ResourceNotFoundException {
		Family familyMember =familyRepository.findById(familyMemberId)
				.orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found for this id :: " + familyMemberId));

		familyMember.setEmail_id(familyMemberDetails.getEmail_id());
		familyMember.setLastName(familyMemberDetails.getLastName());
		familyMember.setFirstName(familyMemberDetails.getFirstName());
		familyMember.setAge(familyMemberDetails.getAge());
		familyMember.setAddress(familyMemberDetails.getAddress());
		familyMember.setGender(familyMemberDetails.getGender());
		familyMember.setMobileNo(familyMemberDetails.getMobileNo());

		final Family updatedFamilyMember = familyRepository.save(familyMember);
		return ResponseEntity.ok(updatedFamilyMember);
	}
	@DeleteMapping("/family/{id}")
	public Map<String, Boolean> deleteFamilyMember(@PathVariable(value = "id") Integer familyMemberId)
			throws ResourceNotFoundException {
		Family famiyMember = familyRepository.findById(familyMemberId)
				.orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found for this id :: " + familyMemberId));

		familyRepository.delete(famiyMember);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
