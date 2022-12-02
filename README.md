## Dapr-Kubernetes-Demo Application

### How to build and start receiver app

```
$ docker build -t receiver-app .
$ docker run --name receiver-app -dp 8080:8080 receiver-app:latest
```