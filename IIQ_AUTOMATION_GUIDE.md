# Adapting this framework to SailPoint IdentityIQ

This repository is a learning framework. The included runnable tests use the public SauceDemo practice site because no IdentityIQ instance or credentials are supplied.

When you receive authorized IIQ lab access:

1. Set `baseUrl` in `src/test/resources/config.properties` to the approved IIQ test URL.
2. Create an IIQ-specific page class under `pages` (for example, `IIQLoginPage`) and inspect the actual page to identify its locators.
3. Keep credentials out of Git. Use environment variables or your organization's approved secrets mechanism.
4. Add tests only for approved test identities and non-production test applications.
5. For an aggregation scenario, use the project's documented process and verify the task status/results shown by that IIQ version. Do not assume a generic locator or page flow: IIQ customizations differ.
6. Never trigger aggregation, provisioning, account changes, or access requests in production without explicit authorization.

## Suggested future IIQ scenarios

- Login and dashboard availability
- Search for an approved test identity
- Validate identity attributes
- Verify an aggregated account/link
- Verify account correlation
- Verify an entitlement or role
- Validate an access request and its approval state
- Verify provisioning outcome in a controlled lab

The current demo login tests do not connect to IIQ and do not validate aggregation.
