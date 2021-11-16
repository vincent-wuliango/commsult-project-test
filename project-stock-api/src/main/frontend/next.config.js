module.exports = {
  reactStrictMode: true,
  env: {
    appName: "Project Test Commsult",
  },

  async rewrites() {
    return [
      {
        source: "/login",
        destination: "/auth/login",
      },
      {
        source: "/register",
        destination: "/auth/register",
      },
    ];
  },
};
