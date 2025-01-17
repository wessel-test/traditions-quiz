# Use a lightweight web server image
FROM nginx:alpine

# Copy the built frontend files to Nginx's html directory
COPY ./src/main/webapp /usr/share/nginx/html

# Expose port 80 for the web server
EXPOSE 80
