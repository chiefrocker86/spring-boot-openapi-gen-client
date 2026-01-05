# Create run image from scratch
FROM scratch
COPY --chown=1000:1000 target/app .
# necessary for the webserver
WORKDIR /tmp
ENTRYPOINT ["/app"]