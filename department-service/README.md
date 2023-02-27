brew install okteto
brew install helm

okteto context use https://cloud.okteto.com

okteto context list //not important

# Generate Repository
## cd department-service where Dockerfile located

okteto build -t okteto.dev/department-service:1.0 .

[//]: # (generated data)
registry.cloud.okteto.net/beyonder12/department-service:1.0

okteto deploy