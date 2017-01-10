({
  mainConfigFile : "${basedir}/src/main/resources/static/main.js",
  baseUrl: '${basedir}/src/main/resources/static',
  dir: "${basedir}/target/webapp-build",
  optimize: '${js.optimize}',
  optimizeCss: '${css.optimize}',
  fileExclusionRegExp: /^(?:node|node_modules|(?:r|build|min)\.js)$/,
  removeCombined: true,
  modules: [
            {
              name: "main"
            }
          ]
})