FROM registry.connect.redhat.com/ibm/ibm-semeru-runtime-certified-25-jre-ubi10-minimal
COPY --chown=1000:1000 target/app.jar .
# necessary for the webserver
WORKDIR /tmp
ENTRYPOINT ["java","-jar","/app.jar"]