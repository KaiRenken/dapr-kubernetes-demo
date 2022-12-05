## Dapr-Kubernetes-Demo Application

This demo application consists of a spring boot application (the consumer) that takes messages and logs them and a
and a producer application that sends a test string to the consumer every 3 seconds. The apps communicate via dapr.

### Prerequisities

To start the example you have to set up a local kubernetes cluster and dapr in the cluster, see: 
https://github.com/dapr/quickstarts/tree/master/tutorials/hello-kubernetes (Step 1 - Setup Dapr on your Kubernetes cluster)

### How to build and deploy to local kubernetes cluster

Just run the script below. It creates a namespace and a local registry, then builds
the consumer-app and the producer-app, pushes them to the registry and deploys them into your kubernetes cluster.
Once finished, you can watch the apps communicate via dapr when you take a look into their pods.

``` shell
$ kubectl apply -f k8s/namespace.yml
$ docker run -d -p 5000:5000 --name registry registry:2

$ docker image rm -f consumer-app
$ docker build -f Dockerfile_Consumer -t consumer-app .
$ docker image tag consumer-app:latest localhost:5000/consumer-app:latest
$ docker image push localhost:5000/consumer-app:latest
$ kubectl delete -f consumer/k8s/deployment.yml
$ kubectl apply -f consumer/k8s/deployment.yml

$ docker image rm -f producer-app
$ docker build -f Dockerfile_Producer -t producer-app .
$ docker image tag producer-app:latest localhost:5000/producer-app:latest
$ docker image push localhost:5000/producer-app:latest
$ kubectl delete -f producer/k8s/deployment.yml
$ kubectl apply -f producer/k8s/deployment.yml
```