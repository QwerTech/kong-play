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
deck gateway dump > kong.yaml
```