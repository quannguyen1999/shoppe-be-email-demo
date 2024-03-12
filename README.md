# shoppe-be-email-demo
# Run docker
# Step 0 run file jar
mvn install -DskipTests -Dmaven.test.skip=true

# Build Docker 
docker build . -t quannguyen1999/shopee-be-email-demo

# Run Docker show log
docker run -p 9000:9000 quannguyen1999/shopee-be-email-demo

# Run Docker without show log 
# 9000 first: is your option
# 9000 second: is container binding
docker run -d -p 9000:9000 quannguyen1999/shopee-be-email-demo

Access: http://localhost:9000

# Link install Kafka
https://kafka.apache.org/quickstart
=> follow this link to run port kafka (port default 9092)