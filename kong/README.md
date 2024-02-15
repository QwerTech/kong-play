https://github.com/kong/kong

To run execute [run-kong.sh](run-kong.sh)

http://localhost:8000 - send traffic to your service via Kong
http://localhost:8001 - configure Kong using Admin API or via decK
http://localhost:8002 - access Kong's management Web UI (Kong Manager) on localhost:8002




 
# Install httpie
https://httpie.io/docs/cli/macos
```bash
brew update
brew install httpie
```

# DecK
## Install decK
https://github.com/kong/deck?tab=readme-ov-file
```bash
brew tap kong/deck
brew install deck
```

## Check version
```bash
http :8001/ | jq ".version"
"3.5.0"
```

## Ping kong
```bash
deck gateway ping
Successfully connected to Kong!
Kong version:  3.5.0
```

## Add service
```bash
http :8001/services name=mockbin url=http://mockbin.org
HTTP/1.1 201 Created
Access-Control-Allow-Credentials: true
Access-Control-Allow-Origin: *
Connection: keep-alive
Content-Length: 368
Content-Type: application/json; charset=utf-8
Date: Tue, 06 Feb 2024 18:06:08 GMT
Server: kong/3.5.0
X-Kong-Admin-Latency: 34

{
"ca_certificates": null,
"client_certificate": null,
"connect_timeout": 60000,
"created_at": 1707242768,
"enabled": true,
"host": "mockbin.org",
"id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0",
"name": "mockbin",
"path": null,
"port": 80,
"protocol": "http",
"read_timeout": 60000,
"retries": 5,
"tags": null,
"tls_verify": null,
"tls_verify_depth": null,
"updated_at": 1707242768,
"write_timeout": 60000
}
```

## Add route mapping
```bash
http :8001/services/mockbin/routes name=root paths=/ -f
HTTP/1.1 201 Created
Access-Control-Allow-Credentials: true
Access-Control-Allow-Origin: *
Connection: keep-alive
Content-Length: 472
Content-Type: application/json; charset=utf-8
Date: Tue, 06 Feb 2024 18:07:47 GMT
Server: kong/3.5.0
X-Kong-Admin-Latency: 14

{
    "created_at": 1707242867,
    "destinations": null,
    "headers": null,
    "hosts": null,
    "https_redirect_status_code": 426,
    "id": "c9d25161-b7ec-4cc7-ad0b-8ae17f62c86e",
    "methods": null,
    "name": "root",
    "path_handling": "v0",
    "paths": [
        "/"
    ],
    "preserve_host": false,
    "protocols": [
        "http",
        "https"
    ],
    "regex_priority": 0,
    "request_buffering": true,
    "response_buffering": true,
    "service": {
        "id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0"
    },
    "snis": null,
    "sources": null,
    "strip_path": true,
    "tags": null,
    "updated_at": 1707242867
}
```

## Export config

```bash
deck gateway dump > config/kong.yaml
```

## Diff
```bash
deck gateway diff config/kong.yaml 
updating service mockbin  {
   "connect_timeout": 60000,
   "enabled": true,
   "host": "mockbin.org",
   "id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0",
   "name": "mockbin",
-  "port": 80,
+  "port": 443,
-  "protocol": "http",
+  "protocol": "https",
   "read_timeout": 60000,
-  "retries": 5,
+  "retries": 1,
   "write_timeout": 60000
 }

Summary:
  Created: 0
  Updated: 1
  Deleted: 0
```

## Sync config
```bash
deck gateway sync config/kong.yaml
updating service mockbin  {
   "connect_timeout": 60000,
   "enabled": true,
   "host": "mockbin.org",
   "id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0",
   "name": "mockbin",
-  "port": 80,
+  "port": 443,
-  "protocol": "http",
+  "protocol": "https",
   "read_timeout": 60000,
-  "retries": 5,
+  "retries": 1,
   "write_timeout": 60000
 }

Summary:
  Created: 0
  Updated: 1
  Deleted: 0

novikopa@bcd074445039 ~/git/QwerTech/tmp-mentoring/kong [master *]
 % Ddeck gateway sync

novikopa@bcd074445039 ~/git/QwerTech/tmp-mentoring/kong [master *]
 % deck gateway sync config/kong.yaml 
Summary:
  Created: 0
  Updated: 0
  Deleted: 0

```

```bash
deck gateway diff config/kong.yaml 
Summary:
  Created: 0
  Updated: 0
  Deleted: 0
```

## Update config in Kong

```bash
http patch :8001/routes/root paths=/evil -f
HTTP/1.1 200 OK
Access-Control-Allow-Credentials: true
Access-Control-Allow-Origin: *
Connection: keep-alive
Content-Length: 476
Content-Type: application/json; charset=utf-8
Date: Tue, 06 Feb 2024 18:32:18 GMT
Server: kong/3.5.0
X-Kong-Admin-Latency: 17

{
    "created_at": 1707242867,
    "destinations": null,
    "headers": null,
    "hosts": null,
    "https_redirect_status_code": 426,
    "id": "c9d25161-b7ec-4cc7-ad0b-8ae17f62c86e",
    "methods": null,
    "name": "root",
    "path_handling": "v0",
    "paths": [
        "/evil"
    ],
    "preserve_host": false,
    "protocols": [
        "http",
        "https"
    ],
    "regex_priority": 0,
    "request_buffering": true,
    "response_buffering": true,
    "service": {
        "id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0"
    },
    "snis": null,
    "sources": null,
    "strip_path": true,
    "tags": null,
    "updated_at": 1707244338
}
```

```bash
deck gateway diff config/kong.yaml 
updating route root  {
   "https_redirect_status_code": 426,
   "id": "c9d25161-b7ec-4cc7-ad0b-8ae17f62c86e",
   "name": "root",
   "path_handling": "v0",
   "paths": [
-    "/evil"
+    "/"
   ],
   "preserve_host": false,
   "protocols": [
     "http",
     "https"
   ],
   "regex_priority": 0,
   "request_buffering": true,
   "response_buffering": true,
   "service": {
     "id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0",
     "name": "mockbin"
   },
   "strip_path": true
 }

Summary:
  Created: 0
  Updated: 1
  Deleted: 0
```

```bash
deck gateway sync config/kong.yaml
updating route root  {
   "https_redirect_status_code": 426,
   "id": "c9d25161-b7ec-4cc7-ad0b-8ae17f62c86e",
   "name": "root",
   "path_handling": "v0",
   "paths": [
-    "/evil"
+    "/"
   ],
   "preserve_host": false,
   "protocols": [
     "http",
     "https"
   ],
   "regex_priority": 0,
   "request_buffering": true,
   "response_buffering": true,
   "service": {
     "id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0",
     "name": "mockbin"
   },
   "strip_path": true
 }

Summary:
  Created: 0
  Updated: 1
  Deleted: 0
```

## Check root route

```bash
http :8001/routes/root                                 
HTTP/1.1 200 OK
Access-Control-Allow-Credentials: true
Access-Control-Allow-Origin: *
Connection: keep-alive
Content-Length: 472
Content-Type: application/json; charset=utf-8
Date: Tue, 06 Feb 2024 18:38:45 GMT
Server: kong/3.5.0
X-Kong-Admin-Latency: 6

{
    "created_at": 1707242867,
    "destinations": null,
    "headers": null,
    "hosts": null,
    "https_redirect_status_code": 426,
    "id": "c9d25161-b7ec-4cc7-ad0b-8ae17f62c86e",
    "methods": null,
    "name": "root",
    "path_handling": "v0",
    "paths": [
        "/"
    ],
    "preserve_host": false,
    "protocols": [
        "http",
        "https"
    ],
    "regex_priority": 0,
    "request_buffering": true,
    "response_buffering": true,
    "service": {
        "id": "39bf3b8d-2a22-4416-92ec-81e3fdea01b0"
    },
    "snis": null,
    "sources": null,
    "strip_path": true,
    "tags": null,
    "updated_at": 1707244444
}
```

# Test the route

```bash
http :8000/actuator       
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/vnd.spring-boot.actuator.v3+json
Date: Tue, 13 Feb 2024 17:16:48 GMT
Transfer-Encoding: chunked
Via: kong/3.5.0
X-Kong-Proxy-Latency: 0
X-Kong-Request-Id: d7ecf836dafae4280e731a1286523f77
X-Kong-Upstream-Latency: 15

{
    "_links": {
        "health": {
            "href": "http://sample-app:8080/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://sample-app:8080/actuator/health/{*path}",
            "templated": true
        },
        "self": {
            "href": "http://sample-app:8080/actuator",
            "templated": false
        }
    }
}
```