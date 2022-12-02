## Dapr-Kubernetes-Demo Application

### How to build and start consumer app locally in docker

``` shell
$ docker build -f Dockerfile_Consumer -t consumer-app .
$ docker run --name consumer-app -dp 8080:8080 consumer-app:latest
```

### How to build and deploy receiver app to local kubernetes cluster

``` shell
$ docker build -f Dockerfile_Consumer -t consumer-app .
$ docker run -d -p 5000:5000 --name registry registry:2
$ docker image tag consumer-app:latest localhost:5000/consumer-app:latest
$ docker image push localhost:5000/consumer-app:latest
$ kubectl apply -f 01-namespace.yml
$ kubectl apply -f consumer/misc/k8s/04-deployment.yml
```