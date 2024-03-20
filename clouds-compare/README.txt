Compare clouds
    General
        Launch year
            GCP 2008 specialized on PaaS for web
            AWS 2004-2006 specialized on IaaS
            Microsoft 2010 fault and then 2013-14 specialized on IaaS for windows
        Top customers
            GCP Activision, Blizzard, Airline, Lufthansa, SpaceX
                Domains
                    Gaming
                    Airlines
                    Aero-cosmic
            Azure AT&T, Coca-cola, walmart
                Domains
                    Telecom
                    Beverages
                    Retail
            AWS Netflix, Twitch, twitter, turner broadcasting, BBC
                Domains
                    Streaming
                    Messaging
                    Media
        Strength
            Azure
                for big enterprises
                Easy transition
                One stop shop to limit their vendor list
            AWS
                Has the largest share of both infrastructure as a service (Iaas) and platform as a service (PaaS) segments
                Longer time experience
                Larger offerings
                Wide community
            GCP
                Provides the most advanced hybrid cloud platform, Google Anthos
                Parents of Kubernetes
                Top leaders from SAP, Oracle with enterprise focus
        Weaknesses
            AWS
                Customers being scared of Amazon scale
                AWS is the main revenue provider and might be separated which is uncertainty
            GCP
                Low adoption among large enterprises
                Aggressive deprecation policies
                GCP is not the main revenue provide for Google, thus it's lower priority
            Azure
                Can require a lot of licences
        Market share
            AWS
                31%
            GCP
                7%

    Compare features
        How?
        Compare DBS, computes, storages
            Compute
                AWS EC2
                    Provides MacOS
                    Provides scaling based on Machine learning
                GCP Compute engine
                    Doesn't provide storage optimized instances

                Azure Virtual machines
                    Provides Windows multiuser
                    Doesn't provide pausing option
                All have similar options
                    Autoscaling and scheduling
                    Autohealing
                    MultiAZ
                    discount up to 70% for 1 or 3 year commitment
                    90% discount on spot instances
                    Burstable instances
            DB
                IaaS
                    MSQL
                        Similar basic capabilities
                        GCP lacks License Mobility
                        Azure provides hybrid benefits+Autopatching+autobackup
                    Oracle
                        GCP doesn't support
                        Azure provides low latency to OCI
                    OpenSource(MySQL, Postgres, MariaDB)
                        Similar low support, but Azure is a bit better
                    Avalability
                        Same 99.99% for multiAZ
                        Single AZ
                            AWS - 90%
                            Azure - 99.9(premium SSD), 99.5(SSD)
                            GCP - 99.5
                    DB marketplace
                        Similar wide offerings
                PaaS
                    AWS is the only provider of Oracle
                    GCP is the only who doesn't support MariaDB
                    Azure has better support for SQL server
                    Azure offers 99.99% vs 99.95 for others
                    Backups
                        Azure - best support in terms of frequency and store time, GCP in middle and AWS worst
                    Scalability
                        GCP offers the biggest possible server storage and RAM
                        Azure the best support for MSQL
                    Security
                        Similar network security capabilities
                        AWS doesn't have client side encryption
                        Azure doesn't have RBAC, but has advanced advisory
                CloudNative PaaS
                    Aws Aurora, Azure SQL DB, GCP Cloud Spanner
                    Similar monitoring features, avalability, but GCP multiregion stand out with 99.999
                    Azure only have RTO and RPO
                    Similar failover features, but it's not automatic in AWS
                    Similar backup features
                    Azure longer restore window - 10 years
                    GCP - no automated backups
                    AWS smalest retentions periods
                    Scalability
                        GCP offers unlimited scalability
                        Similar Read replicas, Sharding, Read-write replica
                        GCP doesn't offer auto pause features, which are used for intermittent and non-prod workloads
                    Security
                        Same as for PaaS
                        GCP doesn't have client side encryption
                NoSQL
                    AWS DynamoDB
                    Azure Cosmos DB
                    GCP Bigtable(BT) & firestore(FS)
                    Similar CLI and UI, local emulators,
                    Different supported languages SDK, but main are supported
                    All provide provisioned and serverles, but BT is Provisioned and FS is serverless
                    Consistency differs
                    Only BT doesn't support CDC
                    BT offers biggest items and FS agilest
                    Preformance similar, but DAX offers sub millisecond
                    BT no autoscaling
                    Similar monitoring
                    FS doesn't have perfomance insigts
                    Similar SLA and failover
                    GCP poor support for backups
                    Similar security approaches, but GCP has some questions
            Conclusion

        Security features? Check what I know, find for constraints, checklists and guidelines, GDPR, Certificates for servers and technology
            Automatic tools
                Password rotation, DDoS, autoscans
                Compare compliance lists
Compare prices
    https://bluexp.netapp.com/blog/google-cloud-pricing-vs-aws-a-fair-comparison-gcp-aws-cvo-blg
    Prices are different for different resources
    Instance are slightly cheaper at AWS
    Frequent access storage is cheaper on AWS
    Infrequent cheaper at GCP
    Archive cheaper on AWS
Security
    https://www.pluralsight.com/resources/videos/cloud-provider-comparisons/cloud-provider-comparisons-aws-vs-azure-vs-gcp-security
    Similarities
        All use shared responsibility model(SRM)
        All provide IAM with MFA, SSO, RBAC, Custom roles
        Similar approaches for DDoS protection(Azure DDoS protection, AWS Shield, Google cloud armor)
        Secrets management
            Azure Key vault
            Aws secrets manager
            Google secret manager
        VPN
            AWS and Azure support point-to-site(P2S) and site-to-site(S2S) 
        Data security
            IAM Policies
            Firewall rules and IP whitelisting
            encryption in transit(TLS)
            encryption at rest(TDE)
        Security compliance
            Azure security center
            GCP trust and security center
            AWS Inspector
            All support ISO 27001,PCI, DSS etc  
    Differences
        Slightly different approaches for SRM
            2 simple categories - AWS
            3 categories(+1 gray area) - Azure
            Complicated model - GCP
        Azure provides Privileged access management(PAM) built-in
        VPN
            Google does not support P2S
        External products
            AWS and Azure offer the widest experience
Performance
    Latencies between endpoints
        https://cloudpingtest.com/
        See the results in [image](ping test.png)
Regions
    https://www.bmc.com/blogs/cloud-availability-regions-zones/
    Of the three major providers, Amazon’s regions and zones are the most developed. Microsoft is comparable. Google is the newest to the scene, but it really isn’t that far behind (and certainly isn’t far behind in any way that makes it less of a viable choice).
    AWS https://aws.amazon.com/about-aws/global-infrastructure/
        33
        105 AZ
        600 CloudFront
        245 countries
    Azure https://datacenters.microsoft.com/?selected_type=infographic#latest-news
        62
        300 AZ
        190 PoP
    GCP https://cloud.google.com/about/locations
        40
        121 AZ
        187 Edge
Trends
    https://www.infoq.com/infoq-trends-report/

	What clouds?
		AWS, GCP, Azure? 
		Oracle and Alibaba why people use those?
		Technology radar
		Check project.epam.com how many projects use these