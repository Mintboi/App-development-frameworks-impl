// HouseholdDTO.java
package com.Project.MartinSwiftImpl.DTOs;

import java.util.Set;

public record HouseholdDTO(Long id, String address, Set<Long> petIds) {}
