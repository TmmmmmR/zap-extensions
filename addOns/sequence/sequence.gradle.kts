description = "Gives the possibility of defining a sequence of requests to be scanned."

zapAddOn {
    addOnName.set("Sequence")

    manifest {
        author.set("ZAP Dev Team")
        url.set("https://www.zaproxy.org/docs/desktop/addons/sequence-scanner/")
        dependencies {
            addOns {
                register("zest") {
                    version.set("48.*")
                }
            }
        }
        extensions {
            register("org.zaproxy.zap.extension.sequence.automation.ExtensionSequenceAutomation") {
                classnames {
                    allowed.set(listOf("org.zaproxy.zap.extension.sequence.automation"))
                }
                dependencies {
                    addOns {
                        register("automation")
                        register("exim") {
                            version.set(">= 0.13")
                        }
                    }
                }
            }
        }
    }
}

dependencies {
    zapAddOn("automation")
    zapAddOn("commonlib")
    zapAddOn("exim")
    zapAddOn("zest")

    testImplementation(project(":testutils"))
}
