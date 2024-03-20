In the table below Quality attributes presented affected by API Gateway compared to BFF.

This should help while choosing between BFF and API Gateway 

### Pros of API GW

| Impact 	| Quality attribute 	| Measurable metric                                                                                                                                                                             	| API Gateway vs BFF influence                                                                                                                                                         	 |
|--------	|-------------------	|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| High   	| Performance       	| Meantime of function call (for web services): ms<br>Throughput                                                                                                                                	| API GW provides smaller latency and throughput                                                                                                                                    	    |
| High   	| Reusability       	| List of exact components/libraries that should be re-usable: <br>API GW should be reused                                                                                                      	| API GW component is highly reusable, <br>while BFF is implemented for exact usecase                                                                                                  	 |
| Avg    	| Security          	| User access is restricted according to authentication/authorization: yes<br>Secured connection: yes<br>Ability to audit and log all user interaction for application critical operations: yes 	| API GW provides authentication and authorization<br>API GW provides SSL out of the box<br>API GW provides audit and logging features                                                 	 |
| Low    	| Scalability       	| System architecture allows horizontal scaling: yes<br>Time needed to scale up/down the system: # of secs/mins                                                                                 	| API GW highly horizontally scalable out of the box<br>API GW start up time is very low                                                                                               	 |
| High   	| Interoperability  	| List of exact supported integration protocols/standards: http, https, grcp<br>Ability to support multiple versions of API: yes<br>Backward compatibility for integration API: 100%            	| API GW provides multiple protocols and protocols conversion as well<br>API GW provides API versioning out of the box<br>API GW provides ability to choose for particular API version 	 |

### Pros of BFF

| Impact 	| Quality attribute 	| Measurable metric                                                                                                                                                                                                                                                                     	| API Gateway vs BFF influence                                                       	|
|--------	|-------------------	|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|------------------------------------------------------------------------------------	|
| Low    	| Performance       	| Degree to which the response and processing times and throughput rates of a product or system, when performing its functions, meet requirements                                                                                                                                       	| With BBF it's possible to aggregate and filter response on server side             	|
| Avg    	| Compatibility     	| Degree to which two or more systems, products or components can exchange information and use the information that has been exchanged                                                                                                                                                  	| BBF provides an agile way of adapting the information to clients needs             	|
| Low    	| Security          	| Confidentiality -<br> Degree to which a product or system ensures that data are accessible only to those authorized to have access.<br>Integrity -<br> Degree to which a system, product or component prevents unauthorized access to, or modification of, computer programs or data. 	| BFF is able to verify and respond with only the data which user has access to      	|
| High   	| Maintainability   	| Reusability -<br> Degree to which an asset can be used in more than one system, or in building other assets.                                                                                                                                                                          	| BFF allows adapting existing components to different user devices, roles and views 	|

Extensibility | Can aggregate response from upstreams | 



Time to market is affected by the implementation of Quality attributes and it impacted significantly for BFF, 
but not as high for API GW
