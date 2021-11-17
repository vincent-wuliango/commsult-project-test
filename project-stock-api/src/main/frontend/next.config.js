module.exports = {
  reactStrictMode: true,
  env: {
    appName: "Project Test Commsult",
  },

  async rewrites() {
    return [
      {
        source: "/login",
        destination: "/pages/auth/login",
      },
      {
        source: "/register",
        destination: "/pages/auth/register",
      },
    ];
  },
};
