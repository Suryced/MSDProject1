#!/bin/bash
docker run -d --network=host bobthebbqmaster/authentication-service
docker run -d --network=host bobthebbqmaster/client-gateway-service
docker run -d --network=host bobthebbqmaster/customers-service
docker run -d --network=host bobthebbqmaster/registrations-service
docker run -d --network=host bobthebbqmaster/events-service

