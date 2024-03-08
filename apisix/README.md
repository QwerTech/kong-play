### access the Admin API
```bash
curl http://127.0.0.1:9180/apisix/admin/routes?api_key=edd1c9f034335f136f87ad84b625c8f1 -i
```




```bash
curl -i "http://127.0.0.1:9180/apisix/admin/routes?api_key=edd1c9f034335f136f87ad84b625c8f1" -X PUT -d '
{
  "id": "sample-app",
  "uri": "/actuator/health",
  "upstream": {
    "type": "roundrobin",
    "nodes": {
      "sample-app:8080": 1
    }
  }
}'
```


```bash
curl "http://127.0.0.1:9080/actuator/health"
```


### Testing load balancing

```bash
curl -i "http://127.0.0.1:9180/apisix/admin/routes?api_key=edd1c9f034335f136f87ad84b625c8f1" -X PUT -d '
{
  "id": "sample-app-balanced",
  "uri": "/actuator/env/HOSTNAME",
  "upstream": {
    "type": "roundrobin",
    "nodes": {
      "sample-app:8080": 1,
      "sample-app2:8080": 1
    },
    "pass_host": "node"
  }
}'
```

```bash
curl "http://127.0.0.1:9080/actuator/env/HOSTNAME"
```

You'll see different hostname values in json

## Key Authentication
### Create a Consumer
```bash
curl -i "http://127.0.0.1:9180/apisix/admin/consumers?api_key=edd1c9f034335f136f87ad84b625c8f1" -X PUT -d '
{
  "username": "tom",
  "plugins": {
    "key-auth": {
      "key": "secret-key"
    }
  }
}'
```

### Enable Authentication
```bash
curl -i "http://127.0.0.1:9180/apisix/admin/routes/sample-app-balanced?api_key=edd1c9f034335f136f87ad84b625c8f1" -X PATCH -d '
{
  "plugins": {
    "key-auth": {}
  }
}'
```

### Without the key
```bash
curl "http://127.0.0.1:9080/actuator/env/HOSTNAME" -i
HTTP/1.1 401 Unauthorized
Date: Thu, 29 Feb 2024 05:01:18 GMT
Content-Type: text/plain; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
Server: APISIX/3.8.0

{"message":"Missing API key found in request"}
```
### With the correct key
```bash
curl "http://127.0.0.1:9080/actuator/env/HOSTNAME" -i -H 'apikey: secret-key'
```

## Disable Authentication
```bash
curl "http://127.0.0.1:9180/apisix/admin/routes/sample-app-balanced?api_key=edd1c9f034335f136f87ad84b625c8f1" -X PATCH -d '
{
  "plugins": {
    "key-auth": {
      "_meta": {
        "disable": true
      }
    }
  }
}'
```

## Rate Limiting

```bash
# maximum of 2 requests within 10 seconds
curl -i "http://127.0.0.1:9180/apisix/admin/routes/sample-app-balanced?api_key=edd1c9f034335f136f87ad84b625c8f1" -X PATCH -d '
{
  "plugins": {
    "limit-count": {
        "count": 2,
        "time_window": 10,
        "rejected_code": 503
     }
  }
}'
```

## Metrics

```bash
curl -i http://127.0.0.1:9091/apisix/prometheus/metrics
```



## Compare APISIX with Kong

Technology maturity
