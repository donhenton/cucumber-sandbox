* CUCUMBER SANDBOX

** Docker Selenium Command

docker run -d -p 4444:4444 --shm-size=2g selenium/standalone-chrome:3.141.59-radium

** Running the Tests

mvn clean verify -Prpn
