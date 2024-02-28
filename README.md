# Shoppe-be-email-demo

# Build Docker 
docker build . -t quannguyen1999/shopee-be-email:0.0.1

# Run Docker show log
docker run -p 9000:9000 quannguyen1999/shopee-be-email:0.0.1

# Run Docker without show log 
# 9000 first: is your option
# 9000 second: is container binding
docker run -d -p 9000:9000 quannguyen1999/shopee-be-email:0.0.1

# Run Docker when container already start 
0e186c2fa29d0abb23f48a8f70f87cdf1a45de23bec1885789e5fae87974b5be
