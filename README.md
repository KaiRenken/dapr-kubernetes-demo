## Dapr-Kubernetes-Demo Application

### How to build and start receiver app locally in docker

```
$ docker build -t receiver-app .
$ docker run --name receiver-app -dp 8080:8080 receiver-app:latest
```

### How to build and deploy receiver app to local kubernetes cluster

```
$ docker build -t receiver-app .
$ docker run -d -p 5000:5000 --name registry registry:2
$ docker image tag receiver-app:latest localhost:5000/myadmin/receiver-app:latest
$ docker image push localhost:5000/myadmin/receiver-app:latest
$ kubectl apply -f 01-namespace.yml
$ kubectl apply -f 04-deployment.yml
```