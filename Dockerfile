FROM java:8-jdk-alpine

COPY build/distributions/email-service.zip /usr/lib/adscoop/email-service.zip

RUN apk update && apk upgrade
RUN apk add bash && apk add screen

RUN cd /usr/lib/adscoop/ && unzip email-service.zip
RUN rm /usr/lib/adscoop/user-service.zip

EXPOSE 8083
