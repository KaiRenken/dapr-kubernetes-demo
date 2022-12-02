## Dapr-Kubernetes-Demo Application

### How to build and start consumer app locally in docker

``` shell
$ docker build -f Dockerfile_Consumer -t consumer-app .
$ docker run --name consumer-app -dp 8080:8080 consumer-app:latest
```

### How to build and deploy receiver app to local kubernetes cluster

``` shell
$ kubectl apply -f misc/k8s/01-namespace.yml
$ docker run -d -p 5000:5000 --name registry registry:2

$ docker image rm -f consumer-app
$ docker build -f Dockerfile_Consumer -t consumer-app .
$ docker image tag consumer-app:latest localhost:5000/consumer-app:latest
$ docker image push localhost:5000/consumer-app:latest
$ kubectl delete -f consumer/misc/k8s/04-deployment.yml
$ kubectl apply -f consumer/misc/k8s/04-deployment.yml
$ kubectl delete -f consumer/misc/k8s/05-service.yml
$ kubectl apply -f consumer/misc/k8s/05-service.yml

$ docker image rm -f producer-app
$ docker build -f Dockerfile_Producer -t producer-app .
$ docker image tag producer-app:latest localhost:5000/producer-app:latest
$ docker image push localhost:5000/producer-app:latest
$ kubectl delete -f producer/misc/k8s/04-deployment.yml
$ kubectl apply -f producer/misc/k8s/04-deployment.yml
```