import '@testing-library/jest-dom';

global.Liferay = {
  Browser: {
    isMobile: function () {
      return false;
    },
  },
  Language: {
    get: function (key) {
      return key;
    },
  },
  ThemeDisplay: {
    getLanguageId: function () {
      return "frCa";
    },
    getPathContext: function () {
      return "";
    },
    getPathThemeImages: function () {
      return "pathThemeImages";
    },
    getPortalURL: function () {
      return "portalURL";
    },
    isSignedIn: function () {
      return true;
    },
    getUserId: function () {
      return 123;
    },
  },
  Util: {
    Session: {
      get: function (attr) {
        return new Promise();
      },
      sub: function _subMock(string, data) {
        return string + data;
      },
    },
  },
  on: function (type, fn, context) {
    return;
  }
};
