# Step 1: Build Vite production bundle
FROM node:18 AS build
WORKDIR /app

RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/yasaswi0209/agriculture-frontend.git .

RUN npm install

# Fix Vite permission issue
RUN chmod +x node_modules/.bin/vite

# Build with Vite
RUN npm run build

# Step 2: Serve build using nginx
FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
