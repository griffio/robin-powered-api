## Robin Powered Api with Retrofit, OkHttp, Gson and AutoValue

updated for [Retrofit2 v2.1.0](https://github.com/square/retrofit)

updated for [OkHttp3 v3.5.0](https://github.com/square/okhttp)

---

When using Intellij 2016 or higher with gradle import, **uncheck** "create separate module per source set" as project needs Autovalue sources on classpath.

---

API token generation located in account integrations: https://dashboard.robinpowered.com/ax/settings/integrations

### Example with TypeAdapterFactory, TypeAdapters, Deserialisers

Robin Powered api uses a "data" element enclosure to wrap resource responses - TypeAdapterFactory can be used to unwrap.

~~~json
{
  "data": [
    {}
  ],
   "meta": {},
   "paging": {
    "page": 1,
    "per_page": 10
   }
}