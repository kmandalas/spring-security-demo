# spring-security-demo
This is a minimal sample for https://github.com/spring-projects/spring-security-oauth/issues/1800

## Run the application

`mvn spring-boot:run`

## Authenticate user / request for Access token
Execute the following:
```
curl --location --request POST 'localhost:8090/oauth/token?grant_type=password&username=user&password=pass' \
--header 'Authorization: Basic Y2xpZW50SWQ6c2VjcmV0'
```
## Refresh token
Execute the following, replacing first with a valid refresh token obtained by the previous call
```
curl --location --request POST 'localhost:8090/oauth/token' \
--header 'Authorization: Basic Y2xpZW50SWQ6c2VjcmV0' \
--header 'Content-Type: multipart/form-data; boundary=--------------------------419560517773604692249683' \
--form 'grant_type=refresh_token' \
--form 'refresh_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwcmVmZXJyZWRUaW1lem9uZSI6IkdNVCArMiIsInVzZXJfbmFtZSI6ImttYW5kYWxhcyIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJvcmdhbml6YXRpb24iOiJrbWFuZGFsYXNNYW5kYWxhcyBTLkEuIiwiYXRpIjoiYzc0YjNhNmUtMmIzMS00NGNmLWJkMWItOTg2MjE1MDkxMzhiIiwiZXhwIjoxNTg0NTM3NDA0LCJkZWZhdWx0UHJvamVjdElkIjoxMDAxLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6IjY4NmZjYmNkLTM2ODgtNDczZC1hZTgwLTljZmZiOTIxMDYxOCIsInVubGltaXRlZENhdGVnb3J5QWNjZXNzIjp0cnVlLCJjbGllbnRfaWQiOiJjbGllbnRJZCJ9.VnR1EEyrGewX5a8j01Cp4psyZG9bmYadRqbrQHHY4ArRiqyaNgG6e9lNHU8Ylcpk5zNpEeOeKTjhoO7esQdynyKviaTdygRQuwAd-X46rpT7MP4dAE6eOvvPWTNVGIYBziyrnBGfeIGXyWN6BdrgEg4rGTPsRk1bVKpemiw1qtSH-MA2IdWZfUXSMwgeCktqdfilbDgObflpjU0AhDVMcqBTFYv2710qZJjtP-6cF_YACmNg-LjMpf_QuH7bJEg6h2ct4jpM2ugJqn-uIlPhcHccVQYOEiEFeirKUJ0J5agKtRgVisYG0RJTW6AwcGEskcVVCo6-yAei-OZ_DvWJ5A'
```
The following **error** occurs:

```
2020-02-17 18:50:12.034  WARN 22484 --- [nio-8090-exec-3] o.s.s.o.provider.endpoint.TokenEndpoint  : Handling error: IllegalStateException, UserDetailsService is required.
```

