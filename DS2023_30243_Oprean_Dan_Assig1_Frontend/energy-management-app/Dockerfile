# build environment
FROM node:18.12.1-alpine as build
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH

ENV REACT_APP_USERHOST http://localhost:3000
ENV REACT_APP_DEVICEHOST http://localhost:3003

COPY package.json ./
COPY package-lock.json ./
RUN npm ci 
RUN npm install react-scripts@3.4.1 -g 
COPY . ./
RUN npm run build

# production environment
FROM nginx:stable-alpine
COPY --from=build /app/build /usr/share/nginx/html
# new
COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
