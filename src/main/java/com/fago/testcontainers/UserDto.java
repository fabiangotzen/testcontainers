package com.fago.testcontainers;

import java.util.UUID;

record UserDto(UUID id, String name, String age) {
}