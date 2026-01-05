# Create run image from scratch
FROM scratch
COPY target/app .
# necessary for the webserver
WORKDIR /tmp
ENTRYPOINT ["/app"]